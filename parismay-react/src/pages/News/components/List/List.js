import * as React from 'react';
import {observer} from 'mobx-react-lite';

import Post from './components/Post';

import './List.scss';

const List = ({store}) => {
	return <div className="list">
		{store.news?.map((el, key) => {
			return <Post key={key} el={el}/>;
		})}
		{store.news.length > 0 && <div className="list__no-posts">Для просмотра авторизуйтесь в одной из соцсетей.</div>}
	</div>;
};

export default observer(List);