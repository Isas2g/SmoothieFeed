import {
	action,
	makeObservable,
	observable,
} from 'mobx';

import {requestVKData} from './requestVKData';

export default class MainStore {
	vkData = [
		{
			type: 'post',
			source_id: 0,
			date: 1637074350,
			post_id: 1,
			post_type: 'post',
			text: 'Всем привет, очень рад вас видеть!',
			photos: [
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
			],
		},
		{
			type: 'post',
			source_id: 0,
			date: 1637074350,
			post_id: 1,
			post_type: 'post',
			text: 'Всем привет, очень рад вас видеть!',
			photos: [
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				}
			],
		},
		{
			type: 'post',
			source_id: 0,
			date: 1637074350,
			post_id: 1,
			post_type: 'post',
			text: 'Всем привет, очень рад вас видеть!',
			photos: [
				{
					id: 1,
					src: '#',
					src_big: '#',
				}
			],
		},
		{
			type: 'post',
			source_id: 0,
			date: 1637074350,
			post_id: 1,
			post_type: 'post',
			text: 'Всем привет, очень рад вас видеть!',
			photos: [],
		},
		{
			type: 'post',
			source_id: 0,
			date: 1637074350,
			post_id: 1,
			post_type: 'post',
			text: 'Всем привет, очень рад вас видеть!',
			photos: [],
		},
		{
			type: 'post',
			source_id: 0,
			date: 1637074350,
			post_id: 1,
			post_type: 'post',
			text: 'Всем привет, очень рад вас видеть!',
			photos: [
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
			],
		},
		{
			type: 'post',
			source_id: 0,
			date: 1637074350,
			post_id: 1,
			post_type: 'post',
			text: 'Всем привет, очень рад вас видеть!',
			photos: [
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
				{
					id: 1,
					src: '#',
					src_big: '#',
				},
			],
		},
	];
	
	constructor() {
		makeObservable(this, {
			vkData: observable,

			fetchVKData: action.bound,
		});
	}
	
	async fetchVKData(type) {
		const {isError, data} = await requestVKData();
		
		this.vkData = data;
	}
	
	destroy() {
	}
}