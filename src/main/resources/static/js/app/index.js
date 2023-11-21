/*
index객체안에 function을 넣은 이유
: 브라우저의 스코프는 공용 공간으로 쓰이기 때문에 동일한 네임이 있을 경우 덮어쓰게 됨.
  이런 문제를 피하려고 index.js 만의 유효범위를 만들어 사용함.
  이렇게 하면 index 객체 안에서만 function이 유효하기 때문에 다른 JS와 겹칠 위험이 사라짐.
 */

var index = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    }
};

index.init();