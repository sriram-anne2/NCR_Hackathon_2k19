const ORDER_HASHTAG = '#tweet2order';
const ORDER_URL = 'http://localhost:8080/orders';
const VALID_EMOJIS_PAYLOAD = 'saladUnicode + chickenUnicode';
const INVALID_EMOJIS_PAYLOAD = 'invalid';

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
	let emojis;
	console.log(tweet);
	if (getEmojis(tweet.text) === '🥗🍗') {
		emojis = VALID_EMOJIS_PAYLOAD;
	} else {
		emojis = INVALID_EMOJIS_PAYLOAD;
	}
	postOrder(ORDER_URL, '@' + tweet.user.screen_name, emojis, tweet.user.id_str);
});

function postOrder(url, screenName, emojis, id) {
	axios
		.post(url, {
			twitterHandle: screenName,
			emojiCode: emojis
		})
		.then(function(response) {
			const msg = `Thank you for your order.\n\nOrder ID:  ${response.data.orderId}\nDescription:  ${response.data
				.orderDescription}\nTotal:  $${response.data.orderTotalPrice}`;
			sendDirectMessage(id, msg);
		})
		.catch(function(error) {
			const msg = "We're sorry, but we were unable to locate that order.  Have you set this order as a favorite? If not head to http://ncrsilverplus.com/account/setFavorites";
			sendDirectMessage(id, msg);
			console.log(error);
		});
}

function sendDirectMessage(userId, msg) {
	const data = {
		event: {
			type: 'message_create',
			message_create: { target: { recipient_id: userId }, message_data: { text: msg } }
		}
	};
	t.post('direct_messages/events/new', data, function(err, data, response) {
		if (err !== undefined) {
			console.error(err);
		}
	});
}

function getEmojis(text) {
	return text
		.match(/(\u00a9|\u00ae|[\u2000-\u3300]|\ud83c[\ud000-\udfff]|\ud83d[\ud000-\udfff]|\ud83e[\ud000-\udfff])/g)
		.join('');
}
