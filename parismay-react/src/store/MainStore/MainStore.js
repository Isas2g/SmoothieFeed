import {
	action,
	makeObservable,
	observable,
} from 'mobx';

import {requestVKData} from './requestVKData';

export default class MainStore {
	vkData = [];
	
	constructor() {
		makeObservable(this, {
			vkData: observable,

			fetchVKData: action.bound,
		});
	}
	
	async fetchVKData() {
		const {isError, data} = await requestVKData();
		
		this.vkData = data;
	}
	
	destroy() {
	}
}