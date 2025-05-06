export default async function handler(req, res) {
  // Sadece POST isteklerini kabul ediyoruz
  if (req.method !== 'POST') {
    return res.status(405).send('Sadece POST istekleri desteklenir');
  }

  // Body'den gelen veriyi alıyoruz
  const { key, msg } = req.body; // Burada req.body kullanıyoruz

  // Güvenlik: API anahtarını doğrulama
  const secretKey = process.env.SECRET_KEY; // Çevre değişkeninden SECRET_KEY alınır
  if (key !== secretKey) {
    return res.status(403).send('Yetkisiz erişim Telegram @TVPUU');
  }

  // Telegram bot token ve chat ID'yi çevre değişkenlerinden alıyoruz
  const telegramToken = process.env.TELEGRAM_BOT_TOKEN;
  const chatId = process.env.TELEGRAM_CHAT_ID;

  // Telegram API URL'si
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage`;

  try {
    // Telegram'a POST isteği gönderiyoruz
    const telegramRes = await fetch(telegramUrl, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        chat_id: chatId,
        text: msg, // Gönderilen mesaj
      }),
    });

    // Telegram API yanıtını alıyoruz
    const telegramData = await telegramRes.json();

    // Telegram API'si başarılı bir şekilde mesajı ilettiyse success=true döner
    if (telegramData.ok) {
      return res.status(200).json({ success: true });
    } else {
      return res.status(500).json({ success: false, message: 'Telegram hatası' });
    }
  } catch (error) {
    console.error(error);
    return res.status(500).send('Telegram API hatası, lütfen tekrar deneyin...');
  }
}
