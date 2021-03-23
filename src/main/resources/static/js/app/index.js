let main = {
    init : function () {
        let _this = this;

        $('#btn-createToken').on('click', () => {
            _this.createToken();
        });

        $('#btn-sendingMsg').on('click', () => {
            _this.sendingMsg();
        });
    },

	// 토큰 생성 Ajax
    createToken : function () {
        // let data = {
        //     content: $('#content').val()
        // };
	
        $.ajax({
            type: 'GET',
            url: '/createToken',
        }).done(function (data) {
			alert("토큰 생성 성공");
			document.querySelector("#content").innerText = data;
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        });
    },

    sendingMsg : function () {
        let samsungMaapResponseDto = {
            messageContact: {
            	userContact: $('#userContact').val()
            },
            RCSMessage: {
            	textMessage: $('#textMessage').val()
            }
        };

        $.ajax({
            type: 'POST',
            url: '/rcs/sendMessage',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(samsungMaapResponseDto)
        }).done(function () {
			alert("API -> MAAP MESSAGE 전송 성공");
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        });
    }
};

main.init();