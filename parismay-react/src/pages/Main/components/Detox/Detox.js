import * as React from 'react';

import DetoxCard from '@components/DetoxCard';

import smoothie from '@assets/images/bg-smoothie-image.png';
import strawberry from '@assets/images/bg-strawberry.png';

import './Detox.scss';

const Detox = ({detoxPrograms}) => {
	return <div className="detox-program">
		<img className="detox-program__smoothie" src={smoothie} alt='#'/>
		<img className="detox-program__strawberry" src={strawberry} alt='#'/>
		<div className="detox-program__title title">Программы digital-детокса</div>
		<div className="detox-program__cards">
			{Object.entries(detoxPrograms).map((el, key) => {
				return <DetoxCard key={key} el={el}/>;
			})}
		</div>
	</div>;
};

export default React.memo(Detox);