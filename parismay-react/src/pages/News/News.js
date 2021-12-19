import * as React from 'react';

import FilterSocial from './components/FilterSocial';
import List         from './components/List';

import social from '@assets/images/bg-social.png';

import './News.scss';
import NewsOnboarding from "@pages/News/components/NewsOnboarding";

const News = ({store, display, onboardingHideDisplay}) => {
	const page = React.useRef(null);
	
	React.useEffect(() => {
		if (localStorage.getItem("vkToken")) {
			store.fetchVKData();
		}
	}, [store]);
	React.useEffect(() => {
		const timeout = setTimeout(() => page.current.classList.add('news_active'), 200);
		
		return () => clearTimeout(timeout);
	}, []);
	
	return <div className="news" ref={page}>
		<NewsOnboarding display={display} onboardingHideDisplay={onboardingHideDisplay}/>
		<img className="news__image" src={social} alt="#"/>
		<div className="news__content container">
			<div className="news__inner">
				<FilterSocial/>
				<List store={store}/>
			</div>
		</div>
	</div>;
};

export default React.memo(News);