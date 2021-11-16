import axios from 'axios';

import {apiUrl} from '@configs/apiUrl';

export const requestVKData = async () => {
	try {
		const response = await axios.get(
			apiUrl.vk.url,
			{
				params: {
				}
			}
		);
		return {
			isError: false,
			data: response.data
		};
	} catch (e) {
		console.log(e);
		return {
			isError: true,
			data: null
		}
	}
}