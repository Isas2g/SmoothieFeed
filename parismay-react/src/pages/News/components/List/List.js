import * as React from 'react';
import {observer} from 'mobx-react-lite';

import Post from './components/Post';

import './List.scss';

const List = ({store}) => {
	return <div className="list">
		{store.vkData.map((el, key) => {
			return <Post key={key} el={el}/>;
		})}
	</div>;
};

export default observer(List);