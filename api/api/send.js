export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  // User-Agent kontrolü (sadece Sketchware izinli)
  const userAgent = req.headers['user-agent'] || '';
  if (!userAgent.toLowerCase().includes('sketchware')) {
    return res.status(403).send('Yetkisiz: Uygulama dışı erişim engellendi');
  }

  const { msg } = req.query;
  if (!msg) {
    return res.status(400).send('Mesaj eksik');
  }

  // Ortam değişkenlerinden token ve chatId alınır
  const telegramToken = process.env.TELEGRAM_TOKEN;
  const chatId = process.env.TELEGRAM_CHAT_ID;

  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(msg)}&parse_mode=Markdown`;

  try {
    const telegramRes = await fetch(telegramUrl);
    const telegramData = await telegramRes.json();

    if (telegramData.ok) {
      return res.status(200).json({ success: true });
    } else {
      return res.status(500).json({ success: false, error: telegramData.description });
    }

  } catch {
    return res.status(500).json({ success: false });
  }
}
