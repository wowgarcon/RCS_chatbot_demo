let main = {
    init : function () {
        let _this = this;

        $('#btn-createToken').on('click', () => {
            _this.createToken();
        });

        $('#btn-sendingMsg').on('click', () => {
            _this.sendingMsg();
        });

        $('#btn-rcsCheckCapabilities').on('click', () => {
            _this.rcsCheckCapabilities();
        });

        $('#btn-callPocGw').on('click', () => {
            _this.callPocGw();
        });
    },

	// 토큰 생성 Ajax
    createToken : () => {
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

    // Maap 메세지 송신
    sendingMsg : () => {
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
    },

    rcsCheckCapabilities : () => {
        let userContact = $('#capabilities').val();

        $.ajax({
            type: 'GET',
            url: '/rcsCheckCapabilities/'+userContact
        }).done(function (data) {
            alert("지원 조회 성공");
            document.querySelector("#capabilitiesList").innerText = data;
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        });
    },

    // 인앱 브라우져 데이터 송신 버튼
    callPocGw : () => {
        let msg = "아이스아메리카노";
        this.callPocGw(msg);
    },

    // 로컬 브라우져 상호작용
    sendResultToChatbot : (msg) => {
        IMessagesCallback.setResult(msg);
        self.close();
    }
};

main.init();