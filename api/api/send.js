export default async function handler(req, res) {
  if (req.method !== 'POST') {
    return res.status(405).json({ error: 'Bize ulaş Telegram : @puutv_admin_bot' });
  }

  const { key, msg } = req.body;

  if (key !== 'ABC123') {
    return res.status(401).json({ error: 'Yetkisiz' });
  }

  const telegramToken = '7426497726:AAEPDzRSsXjAvTFpN_B7bteQj00a6wacSAg';
  const chatId = '1224314188';
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(msg)}`;

  try {
    const telegramRes = await fetch(telegramUrl);
    const data = await telegramRes.json();
    res.status(200).json({ success: true, telegram: data });
  } catch (err) {
    res.status(500).json({ error: 'Telegram isteği başarısız', detay: err.message });
  }
}

