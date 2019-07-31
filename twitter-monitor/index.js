const ORDER_HASHTAG = '#tweet2order';

const twit = require('twit');
const axios = require('axios');

let t = new twit({
	consumer_key: '3pPUFTe5Rvfm1AwkXqZjEN3hN',
	consumer_secret: '7r4Mcr1X4IU9bnPTUCZK0XUA952Wm7fpy2z0dNoVaANFbLWJqw',
	access_token: '1155859007061540867-5oxIGqF8nTe8Cj9W2fDDYLyt8npXcg',
	access_token_secret: 'll1YUM63Ou0TDtZjfKzhuHVwMdyrzbIVOKz2NzwOsuUjq',
	timeout_ms: 60 * 1000, // optional HTTP request timeout to apply to all requests.
	strictSSL: true // optional - requires SSL certificates to be valid.
});

let stream = t.stream('statuses/filter', { track: ORDER_HASHTAG });

stream.on('tweet', function(tweet) {
	console.log(tweet);
	axios
		.post('localhost:8080/orders', {
			twitterHandle: tweet.user.sceen_name,
			recipientId: tweet.user.id_str,
			emojiCode: getEmojis(tweet.text)
		})
		.then(function(response) {
			console.log(response);
		})
		.catch(function(error) {
			console.log(error);
		});
});

function getEmojis(text) {
	return text.match(/(\u00a9|\u00ae|[\u2000-\u3300]|\ud83c[\ud000-\udfff]|\ud83d[\ud000-\udfff]|\ud83e[\ud000-\udfff])/g);
}

// let emojis = '🍩🍭🍪🍊🌮';
// console.log(getEmojis(emojis));