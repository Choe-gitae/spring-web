$(function () {
    // 댓글 추가 버튼이 눌렸을 때
    $("#replyConfirm").click(function () {
        var param = $("#replyForm").serialize();
        //console.log(param);

        $.ajax({
            type: "post",
            url: "../replies/new",
            data: param,
            success: function (result) {
                console.log(result);
                $("#reply").val("");
                replyList();
            },
            error: function (err) {
                alert(err);
                console.log(err);
            },
        });
    }); // end click

    replyList();
    function replyList() {
        $.ajax({
            type: "get",
            url: "../replies",
            dataType: "Json",
            success: function (result) {
                var table = $("#replyTable");
                table.empty();

                for (let row of result) {
                    //console.log(row);
                    var tr = $("<tr/>");
                    var reply = row["reply"];
                    tr.append($("<td/>").html(row["rno"]));
                    tr.append($("<td/>").html(row["replyer"]));
                    tr.append($("<td/>").append($("<input type='text' id='reply' readonly />").val(reply)));
                    //tr.append($("<td/>").html(row["reply"]));
                    tr.append($("<td/>").html(row["replydate"]));
                    tr.append("<td><button class='delete'>삭제</button></td>");
                    tr.append("<td><button class='modify'>수정</button></td>");
                    table.append(tr);
                }
            },
            error: function (err) {
                alert(err);
                console.log(err);
            },
        });
    } // end replyList()

    // 삭제 버튼 눌렸을 때
    $("#replyTable").on("click", ".delete", function () {
        //alert("삭제");
        var rno = $(this).parents("tr").find("td:eq(0)").text();
        $.ajax({
            type: "delete",
            url: "../replies/" + rno,
            success: function () {
                replyList();
            },
            error: function () {
                alert("에러");
            },
        }); //end ajax
    }); // end click

    // 수정 버튼 눌렸을 때
    $("#replyTable").on("click", ".modify", function () {
        var reply = $(this).parents("tr").find("#reply");
        var button = $(this).parents("tr").find(".modify");
        reply.removeAttr("readonly");
        button.attr("class", "modifyConfirm").text("수정적용");
        reply.focus();
        //$(this).append("<td><button class='modifyConfirm'>수정적용</button></td>");
    }); // end click

    // 수정 적용 버튼 눌렀을 때
    $("#replyTable").on("click", ".modifyConfirm", function () {
        var rno = $(this).parents("tr").find("td:eq(0)").text();
        var reply = $(this).parents("tr").find("#reply");

        $.ajax({
            type: "post",
            url: "../repliesModify",
            data: { rno: rno, reply: reply.val() },
            success: function () {
                replyList();
            },
            error: function () {
                alert("에러");
            },
        }); //end ajax
    }); // end click
});
