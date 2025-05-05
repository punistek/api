export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  const { msg } = req.query;

  const telegramToken = '7426497726:AAEPDzRSsXjAvTFpN_B7bteQj00a6wacSAg';
  const chatId = '1224314188';
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(msg)}`;

  try {
    const telegramRes = await fetch(telegramUrl);
    const telegramData = await telegramRes.json();
    res.status(200).json({ success: true, telegram: telegramData });
  } catch (error) {
    res.status(500).send('Telegram gönderimi başarısız');
  }
}
