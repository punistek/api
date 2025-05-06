export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  const userAgent = req.headers['user-agent'] || '';
  if (!userAgent.toLowerCase().includes('Livetv')) {
    return res.status(403).send('Yetkisiz: Uygulama dışı erişim engellendi');
  }

  const { msg } = req.query;

  if (!msg) {
    return res.status(400).send('Mesaj eksik');
  }

  const telegramToken = process.env.TELEGRAM_BOT_TOKEN;
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
