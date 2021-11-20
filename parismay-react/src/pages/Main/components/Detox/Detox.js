import * as React from 'react';

import DetoxCard from '@components/DetoxCard';

import smoothie from '@assets/images/bg-smoothie-image.png';
import strawberry from '@assets/images/bg-strawberry.png';

import './Detox.scss';

const Detox = ({detoxPrograms}) => {
	return <div className="container-bg-image-smoothie">
		<div className="container-bg-image-strawberry">
			<div className="container-bg-image-banana">
				<div className="detox-program">
					<div className="container">
						<div className="detox-program__inner">
							<h2 className="detox-program__title">Программы digital-детокса</h2>
							<div className="detox-program__cards">
								{Object.entries(detoxPrograms).map((el, key) => {
									return <DetoxCard key={key} el={el}/>;
								})}
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
};


export default React.memo(Detox);