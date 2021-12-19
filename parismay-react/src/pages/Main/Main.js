import * as React from 'react';

import Preview    from './components/Preview';
import HowItWorks from './components/HowItWorks';
import Detox      from './components/Detox';
import Reviews    from './components/Reviews';

import './Main.scss';
import MainOnboarding from "@pages/Main/components/MainOnboarding";
import {useState} from "react";

const Main = ({detoxPrograms, reviews, display, onboardingDisplay}) => {
	const page = React.useRef(null);

	React.useEffect(() => {
		const timeout = setTimeout(() => page.current.classList.add('main_active'), 200);
		
		return () => clearTimeout(timeout);
	}, []);

	return <div ref={page} className="main">
		<button onClick={() => onboardingDisplay(display)} className="tutorial-button">Туториал</button>
		<MainOnboarding display={display} />
		<Preview/>
		<HowItWorks/>
		<Detox detoxPrograms={detoxPrograms}/>
		<Reviews reviews={reviews}/>
	</div>;
};

export default React.memo(Main);