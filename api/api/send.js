export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  // User-Agent kontrolü (sadece Sketchware veya senin belirlediğin bir istemci geçebilir)
  const userAgent = req.headers['user-agent'] || '';
  if (!userAgent.toLowerCase().includes('sketchware')) {
    return res.status(403).send('Yetkisiz: Uygulama dışı erişim engellendi');
  }

  const { msg } = req.query;

  if (!msg) {
    return res.status(400).send('Mesaj eksik');
  }

  const telegramToken = '7426497726:AAEPDzRSsXjAvTFpN_B7bteQj00a6wacSAg';
  const chatId = '1224314188';
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(msg)}&parse_mode=Markdown`;

  try {
    const telegramRes = await fetch(telegramUrl);
    const telegramData = await telegramRes.json();

    if (telegramData.ok) {
      return res.status(200).json({ success: true });
    } else {
      return res.status(500).json({ success: false, error: telegramData.description });
    }

  } catch (error) {
    return res.status(500).json({ error: 'Telegram gönderim hatası', detail: error.message });
  }
}
