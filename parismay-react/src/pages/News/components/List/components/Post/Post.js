import * as React from 'react';
import {observer} from 'mobx-react-lite';

import './Post.scss';

const Post = ({el}) => {
	const normalizedDate = React.useMemo(() => {
		const date = new Date(el.date * 1000);
		
		const year = date.getFullYear();
		const month = "0" + (date.getMonth() + 1);
		const day = date.getDate();
		
		const hours = date.getHours();
		const minutes = "0" + date.getMinutes();
		const seconds = "0" + date.getSeconds();
		
		return `${day}.${month.substr(-2)}.${year} ${hours}:${minutes.substr(-2)}:${seconds.substr(-2)}`;
	}, [el]);
	
	return <div className="post">
		<div className="post__header">
			<div className="post__icon"/>
			<div className="post__info">
				<div className="post__title">Паблик для тестов</div>
				<div className="post__time">{normalizedDate}</div>
			</div>
		</div>
		<div className="post__body post-body">
			<div className="post-body__text">{el.text}</div>
			<div className="post-body__attachments">
				{el.photos.map((el, key) => {
					return <div key={key} className="post-body__photo"/>
				})}
			</div>
		</div>
	</div>;
};

export default observer(Post);