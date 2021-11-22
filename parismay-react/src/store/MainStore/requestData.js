import axios from 'axios';

import {apiUrl} from '@configs/apiUrl';

import {normalizeVKData} from '@store/normalizedData/VK';

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
					count: 100,
					v: '5.131',
				},
			},
		);
		return {
			isError: false,
			data: normalizeVKData(response.data.response),
		};
	} catch (e) {
		console.log(e);
		return {
			isError: true,
			data: null,
		};
	}
};

export const requestInstagramData = async () => {
	try {
		const response = await axios.get(
			apiUrl.vk.url,
			{
				params: {
					access_token: localStorage.getItem('vkToken'),
					filters: 'post',
					max_photos: 100,
					source_ids: 'friends,groups,pages',
					count: 100,
					v: '5.131',
				},
			},
		);
		return {
			isError: false,
			data: normalizeVKData(response.data.response),
		};
	} catch (e) {
		console.log(e);
		return {
			isError: true,
			data: null,
		};
	}
};