export default async function handler(req, res) {
  if (req.method !== 'POST') {
    return res.status(405).send('Sadece POST istekleri desteklenir');
  }

  const { key, msg } = req.body;

  const secretKey = 'ABC123';
  if (key !== secretKey) {
    return res.status(403).send('Yetkisiz erişim');
  }

  const telegramToken = '7426XXXXXXXX:XXXXXXXXXXXX'; // Token gizli kalsın
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
