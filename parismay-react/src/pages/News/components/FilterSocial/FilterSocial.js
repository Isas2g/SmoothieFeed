import * as React from 'react';
import cn         from 'classnames';

import vkIcon      from '@assets/images/social-vk.svg';
import instIcon    from '@assets/images/social-instagram.svg';
import fbIcon      from '@assets/images/social-facebook.svg';
import twitterIcon from '@assets/images/social-twitter-2.svg';

import {CLIENT_ID, DEFAULT_REDIRECT_URI} from '@configs/apiUrl';

import './FilterSocial.scss';

const FilterSocial = () => {
	const [vkStatus, setVKStatus] = React.useState(localStorage.getItem('vkStatus')),
		[instStatus, setInstStatus] = React.useState(localStorage.getItem('instStatus')),
		[fbStatus, setFBStatus] = React.useState(localStorage.getItem('fbStatus')),
		[twitterStatus, setTwitterStatus] = React.useState(localStorage.getItem('twitterStatus'));
	
	React.useEffect(() => {
		if (!localStorage.getItem('vkToken')) setVKStatus('false');
		else setVKStatus('true');
		
		if (!localStorage.getItem('instToken')) setInstStatus('false');
		else setInstStatus('true');
		
		if (!localStorage.getItem('fbToken')) setFBStatus('false');
		else setFBStatus('true');
		
		if (!localStorage.getItem('twitterToken')) setTwitterStatus('false');
		else setTwitterStatus('true');
	}, []);
	
	return <div className="filter-social">
		<a
			href={`https://oauth.vk.com/authorize?client_id=${CLIENT_ID}&redirect_uri=${DEFAULT_REDIRECT_URI}&scope=73730&response_type=token&v=5.131`}
			rel="noreferrer"
		>
			<img
				className={cn('filter-social__item', vkStatus === 'true' ? 'filter-social__item_active' : null)}
				src={vkIcon}
				alt="VK"
			/>
		</a>
		<img
			className={cn('filter-social__item', instStatus === 'true' ? 'filter-social__item_active' : null)}
			src={instIcon}
			alt="Instagram"
		/>
		<img
			className={cn('filter-social__item', fbStatus === 'true' ? 'filter-social__item_active' : null)}
			src={fbIcon}
			alt="Facebook"
		/>
		<img
			className={cn('filter-social__item', twitterStatus === 'true' ? 'filter-social__item_active' : null)}
			src={twitterIcon}
			alt="Twitter"
		/>
	</div>;
};

export default React.memo(FilterSocial);