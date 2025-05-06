export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  const { msg } = req.query;

  if (!msg) {
    return res.status(400).send('Mesaj eksik');
  }

  // Ortam değişkenlerinden token ve chatId alınıyor
  const telegramToken = process.env.TELEGRAM_TOKEN;
  const chatId = process.env.TELEGRAM_CHAT_ID;

  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(msg)}&parse_mode=Markdown`;
console.log("TOKEN:", telegramToken);
console.log("CHAT ID:", chatId);
return res.status(200).json({ token: telegramToken, chatId });

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
