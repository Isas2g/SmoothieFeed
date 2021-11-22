export const normalizeVKData = (data) => {
	if (data) {
		const posts = data.items;
		
		const result = [];
		
		const bannedTypes = [
			'video',
			'audio',
			'doc',
			'graffiti',
			'link',
			'note',
			'app',
			'poll',
			'page',
			'album',
			'market',
			'market_album',
			'sticker',
			'pretty_cards',
			'event',
		];
		
		for (const el of posts) {
			if (!el.marked_as_ads) {
				if (el.attachments?.filter(el => bannedTypes.includes(el.type)).length === 0) {
					if (String(result.length) !== localStorage.getItem('postsLimit')) {
						const groupID = el.source_id * -1;
						const group = data.groups.filter(el => el.id === groupID)[0];
						
						const attachments = [];
						
						if (el.attachments) {
							for (const attachment of el.attachments) {
								attachments.push(attachment.photo.sizes[attachment.photo.sizes.length - 1].url);
							}
						}
						
						result.push({
							attachments: attachments,
							text: el.text,
							date: el.date,
							author: {
								icon: group.photo_50,
								name: group.name,
							},
						});
					}
				}
			}
		}
		
		return result;
	}
};