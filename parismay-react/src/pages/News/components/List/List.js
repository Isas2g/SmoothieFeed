import * as React from 'react';
import {observer} from 'mobx-react-lite';

import Post from './components/Post';

import './List.scss';

const List = ({store}) => {
	return <div className="list">
		{store.vkData?.items?.map((el, key) => {
			const groupID = store.vkData.items[key].source_id * -1;
			const group = store.vkData.groups.filter(el => el.id === groupID)[0];
			
			return <Post key={key} el={el} group={group}/>;
		})}
		{!store.vkData?.items && <h2 className="list__no-posts">Для просмотра авторизуйтесь в одной из соцсетей.</h2>}
	</div>;
};

export default observer(List);