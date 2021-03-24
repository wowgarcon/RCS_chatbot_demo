package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Action {
	/*
	 * Text to display for the suggestion.
	 */
	private String displayText;
	/*
	 * [Optional] Open a web site.
	 */
	private UrlAction urlAction;
	/*
	 * [Optional] Open a web site in localBrowser.
	 */
	private LocalBrowserAction localBrowserAction;
	/*
	 * [Optional] start Audio/Video/Enriched call via dialer.
	 */
	private DialerAction dialerAction;
	/*
	 * [Optional] show location on a map or request for one-time location push.
	 */
	private MapAction mapAction;//사용하지 않아 미구현
	/*
	 * [Optional] Create a new calendar event.
	 */
	private CalendarAction calendarAction;//사용하지 않아 미구현
	/*
	 * [Optional] Compose a draft message or start recording audio/video.
	 */
	private ComposeAction composeAction;//사용하지 않아 미구현
	/*
	 * [Optional] Request for device specific information.
	 */
	private DeviceAction deviceAction;//사용하지 않아 미구현
	/*
	 * [Optional] Update device settings like disable anonymization and enable sending displayed notification.
	 */
	private SettingsAction settingsAction;//사용하지 않아 미구현
	/*
	 * [Optional] his is the message body to send back to bot.
	 */
	private Postback postback;
	private Result result;
}
