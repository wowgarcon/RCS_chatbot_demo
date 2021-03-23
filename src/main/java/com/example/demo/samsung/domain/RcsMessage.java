package com.example.demo.samsung.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"messageHeader","messageFooter","richcardMessage"})
@Getter
@Setter
public class RcsMessage {
	
	/*
	 * [Optional] This is the identifier of the message, and this value is provided by the Chatbot Platform only.
	 */
	private String msgId;
	/*
	 * [Optional] The status of message such as "pending", "sent", "delivered", "displayed", "canceled", "revoked" and "failed". Status will be updated in webhook callback event and is also available for query with msgId.
	 * pending - it may take further process before the message can be sent to the contact
	 * sent - the message has been sent to the contact via operator's network
	 * delivered - the message has been successfully delivered to the contact
	 * displayed - the contact has read the message
	 * canceled - the message has been requested to be revoked by the sender
	 * revoked - the message has been revoked successfully
	 * failed - fail to send the message
	 */
	private String status;
	/*
	 *[Optional] This is traffic type specified in US15-7 of RCC.71 and 3.6.7.2 of RCC.07 . The Chatbot should set this value if the traffic belongs one of required type based on the agreement between the Chatbot Platform and the Chatbot.
 	 * advertisement
 	 * payment
	 * premium
	 * subscription 
	 */
	private String trafficType;
	/*
	 * [Optional] RCS Chat message defined in 3.2.3 of RCC.07 .
	 */
	private String textMessage;
	/*
	 * [Optional] File information to be sent via RCS File Transfer defined in 3.2.5 of RCC.07 .
	 */
	private FileMessage fileMessage;
	/*
	 * [Optional] Audio file information to be sent via RCS Audio Message defined in 3.2.7 of RCC.07 .
	 */
	private AudioMessage audioMessage;
	/*
	 * [Optional] Geolocation info to be sent via RCS Geolocation Push defined in 3.2.6 of RCC.07 .
	 */
	
	private GeolocationPushMessage geolocationPushMessage;
	/*
	 * [Optional] Its the rich card message with media and suggested actions/replies following UP 2.0 specification. Please refer to Message Template section for more details.
	 */
	private RichcardMessage richcardMessage;
	/*
	 * [Optional] Suggested actions from bot to client following UP 2.0 specification. Please refer to Message Template section for more details.
	 */
	private SuggestedChipList suggestedChipList;
	
	/*
	 * [Optional] The response from client to Bot for suggested action/reply following UP 2.0 specification.
	 */
	private SuggestedResponse suggestedResponse;
	/*
	 * [Optional] Its the device specific information which client can share to bot following UP 2.0 specification as a result of user response to suggested action "requestDeviceSpecifics".
	 */
	private SharedData sharedData;
	
	/*
	 * [Optional] The isTyping notification to be sent to the user for the given Chat, and it should be used separately from 'message'. Value can be set to 'active' or 'idle'.
	 */
	
	private String isTyping;
	/*
	 * [Optional] The expiry of this message. The Chatbot platform will try to revoke this message after this expiry.
	 */
	private String expiry;
	
	/*
	 * [Optional] message last updated timestamp. Should use Zulu time in ISO 8601 format (e.g., [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss]Z). Such as: "2017-08-14T21:19:57.107Z"
	 */
	private String timestamp;
	
	/*
	 * openRichCard
	 */
//	private String messageHeader;
//	private String messageFooter;
	private OpenrichcardMessage openrichcardMessage;
}