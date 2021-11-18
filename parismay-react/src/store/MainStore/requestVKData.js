import axios from 'axios';

import {apiUrl} from '@configs/apiUrl';

export const requestVKData = async () => {
	try {
		const response = await axios.get(
			apiUrl.vk.url,
			{
				params: {
					access_token: localStorage.getItem('vkToken'),
					filters: 'post',
					max_photos: 100,
					source_ids: 'friends,groups,pages',
					count: 50,
					v: '5.131',
				},
			},
		);
		return {
			isError: false,
			data: response.data.response,
		};
	} catch (e) {
		console.log(e);
		return {
			isError: true,
			data: null,
		};
	}
};