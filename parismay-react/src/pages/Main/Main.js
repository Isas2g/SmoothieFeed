import * as React from 'react';

import Header     from '@components/Header/Header';
import Preview    from './components/Preview';
import HowItWorks from './components/HowItWorks';
import Detox      from './components/Detox';
import Reviews    from './components/Reviews';

import './Main.scss';

const Main = ({detoxPrograms, reviews}) => {
	return <div>
		<Header/>
		<main className="main">
			<Preview/>
			<HowItWorks/>
			<Detox detoxPrograms={detoxPrograms}/>
			<Reviews reviews={reviews}/>
		</main>
	</div>;
};

export default React.memo(Main);