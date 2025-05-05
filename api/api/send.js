export default async function handler(req, res) {
  if (req.method !== 'GET') {
    return res.status(405).send('Sadece GET istekleri desteklenir');
  }

  const { key, msg } = req.query;

  // 1. Güvenlik anahtarı kontrolü (ENV’den okunuyor)
  const secretKey = process.env.SECRET_KEY;
  if (key !== secretKey) {
    return res.status(403).send('Yetkisiz erişim Telegram @TVPUU');
  }

  // 2. Telegram’a gönderim için gerekli ENV’ler
  const telegramToken = process.env.TELEGRAM_TOKEN;
  const chatId        = process.env.TELEGRAM_CHAT_ID;
  const apiBase       = process.env.TELEGRAM_API_URL || 'https://api.telegram.org';

  const telegramUrl = `${apiBase}/bot${telegramToken}/sendMessage` +
                      `?chat_id=${chatId}&text=${encodeURIComponent(msg)}`;

  try {
    await fetch(telegramUrl);
    res.status(200).json({ success: false });
  } catch (error) {
    // Hata olsa da kullanıcıya aynı cevap verilsin
    res.status(200).json({ success: false });
  }
}
