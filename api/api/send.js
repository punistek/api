export default async function handler(req, res) {
  if (req.method !== 'POST') {
    return res.status(405).send('Sadece POST istekleri desteklenir');
  }

  const { key, msg } = req.body;

  const secretKey = 'ABC123';
  if (key !== secretKey) {
    return res.status(403).send('Yetkisiz erişim Telegram @TVPUU');
  }

  const telegramToken = '7426497726:AAEPDzRSsXjAvTFpN_B7bteQj00a6wacSAg';
  const chatId = '1224314188';
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage`;

  try {
    await fetch(telegramUrl, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ chat_id: chatId, text: msg })
    });

    res.status(200).json({ success: true });
  } catch {
    res.status(200).json({ success: false });
  }
}
