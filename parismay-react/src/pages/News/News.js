import * as React from 'react';

import FilterSocial from './components/FilterSocial';
import List         from './components/List';

import social from '@assets/images/bg-social.png';

import './News.scss';

const News = ({store}) => {
	const page = React.useRef(null);
	
	React.useEffect(() => {
		const timeout = setTimeout(() => page.current.classList.add('news_active'), 200);
		
		return () => clearTimeout(timeout);
	}, []);
	
	return <div className="news" ref={page}>
		<img className="news__image" src={social} alt="#"/>
		<div className="news__content">
			<div className="news__title title">Новости</div>
			<div className="news__inner">
				<FilterSocial/>
				<List store={store}/>
			</div>
		</div>
	</div>;
};

export default React.memo(News);