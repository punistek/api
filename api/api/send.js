export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  const { url, device, android } = req.query;
  const time = new Date().toLocaleString('tr-TR', { timeZone: 'Europe/Istanbul' });

  const message = `Yeni M3U URL Alındı!\n\nURL: ${url}\nCihaz Modeli: ${device}\nAndroid Sürümü: ${android}\nZaman: ${time}`;

  const telegramToken = '7426497726:AAEPDzRSsXjAvTFpN_B7bteQj00a6wacSAg';
  const chatId = '1224314188';
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(message)}`;

  try {
    const telegramRes = await fetch(telegramUrl);
    const telegramData = await telegramRes.json();
    res.status(200).json({ success: true, telegram: telegramData });
  } catch (error) {
    console.error('Telegram hatası:', error);
    res.status(500).send('Telegram isteği başarısız');
  }
}
