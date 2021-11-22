import {
	action,
	makeObservable,
	observable,
} from 'mobx';

import {requestVKData} from './requestData';

export default class MainStore {
	news = [];
	
	constructor() {
		makeObservable(this, {
			news: observable,
			
			fetchVKData: action.bound,
		});
	}
	
	async fetchVKData() {
		const {isError, data} = await requestVKData();
		
		if (!isError && data) {
			this.news = this.news.concat(data);
		}
	}
	
	destroy() {
	}
}