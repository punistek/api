export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  const { key, msg } = req.query;

  const secretKey = process.env.SECRET_KEY;
  if (key !== secretKey) {
    return res.status(403).send('Yetkisiz erişim Telegram @TVPUU');
  }

  const telegramToken = process.env.TELEGRAM_BOT_TOKEN;
  const chatId = process.env.TELEGRAM_CHAT_ID;
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage`;

  try {
    const telegramRes = await fetch(telegramUrl, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        chat_id: chatId,
        text: msg,
      }),
    });

    const telegramData = await telegramRes.json();
    res.status(200).json({ success: telegramData.ok });
  } catch (error) {
    res.status(500).send('Listen gelmedi ise telegrama gel...');
  }
}
