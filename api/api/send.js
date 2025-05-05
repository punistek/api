export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  const { key, msg } = req.query;

  // 1. Güvenlik anahtarı kontrolü
  const secretKey = 'ABC123';
  if (key !== secretKey) {
    return res.status(403).send('Yetkisiz erişim');
  }

  // 2. Telegram'a gönderilecek mesaj
  const telegramToken = '7426497726:AAEPDzRSsXjAvTFpN_B7bteQj00a6wacSAg';
  const chatId = '1224314188';
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(msg)}`;

  try {
    // Telegram'a mesaj gönderimi
    const telegramRes = await fetch(telegramUrl);
    const telegramData = await telegramRes.json();

    // Yanıtta yalnızca success'ı false olarak döndür
    res.status(200).json({ success: false });

  } catch (error) {
    res.status(500).send('Telegram gönderimi başarısız');
  }
}
