export default async function handler(req, res) {
  if (req.method !== 'POST') {
    return res.status(405).json({ error: 'Bize ulaş Telegram : @puutv_admin_bot' });
  }

  const { key, msg } = req.body;

  if (key !== 'ABC123') {
    return res.status(401).json({ error: 'Yetkisiz' });
  }
  
  const telegramToken = process.env.TELEGRAM_BOT_TOKEN;
  const chatId = process.env.TELEGRAM_CHAT_ID;
  const telegramUrl = `https://api.telegram.org/bot${telegramToken}/sendMessage?chat_id=${chatId}&text=${encodeURIComponent(msg)}`;

  try {
    // Telegram API isteği yapıyoruz ama yanıtını kullanmıyoruz
    await fetch(telegramUrl);
    // İstemciye sadece başarılı olduğunu belirten bir yanıt dönüyoruz
    res.status(200).json({ success: true });
  } catch (err) {
    // Hata durumunda da sadece hata mesajı dönüyoruz, Telegram yanıtını kullanmıyoruz
    res.status(500).json({ error: 'Telegram isteği başarısız', detay: err.message });
  }
}
