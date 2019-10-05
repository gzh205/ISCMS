function upload(basestr, type, $li) {
    var text = window.atob(basestr.split(",")[1]);
    var buffer = new ArrayBuffer(text.length);
    var ubuffer = new Uint8Array(buffer);
    var pecent = 0 , loop = null;

    for (var i = 0; i < text.length; i++) {
        ubuffer[i] = text.charCodeAt(i);
    }

    var Builder = window.WebKitBlobBuilder;
    var blob;

    if (Builder) {
        var builder = new Builder();
        builder.append(buffer);
        blob = builder.getBlob(type);
    } else {
        blob = new window.Blob([buffer], {type: type});
    }

    var xhr = new XMLHttpRequest();
    var formdata = new FormData();
    formdata.append("imagefile", blob);

    xhr.open("post", "/cupload");

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log("上传成功：" + xhr.responseText);

            clearInterval(loop);

            //当收到该消息时上传完毕
            $li.find(".progress span").animate({"width": "100%"}, pecent < 95 ? 200 : 0, function () {
                $(this).html("上传成功");
            });

            $(".pic-list").append("<a href='" + xhr.responseText + "'>" + xhr.responseText + "<img src='" + xhr.responseText + "'/></a>")
        }
    };

    //数据发送进度，前50%展示该进度
    xhr.upload.addEventListener("progress", function (e) {
        if (loop) return;

        pecent = ~~(100 * e.loaded / e.total) / 2;
        $li.find(".progress span").css("width", pecent + "%");

        if (pecent == 50) {
            mockProgress();
        }
    }, false);

    //数据后50%用模拟进度
    function mockProgress() {
        if (loop) return;

        loop = setInterval(function () {
            pecent++;
            $li.find(".progress span").css("width", pecent + "%");

            if (pecent == 99) {
                clearInterval(loop);
            }
        }, 100)
    }

    xhr.send(formdata);
}
function compress(img) {
    var initSize = img.src.length;
    var width = img.width;
    var height = img.height;

    //如果图片大于四百万像素，计算压缩比并将大小压至400万以下
    var ratio;
    if ((ratio = width * height / 4000000)>1) {
        ratio = Math.sqrt(ratio);
        width /= ratio;
        height /= ratio;
    }else {
        ratio = 1;
    }

    canvas.width = width;
    canvas.height = height;

//    铺底色
    ctx.fillStyle = "#fff";
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    //如果图片像素大于100万则使用瓦片绘制
    var count;
    if ((count = width * height / 1000000) > 1) {
        count = ~~(Math.sqrt(count)+1); //计算要分成多少块瓦片

//        计算每块瓦片的宽和高
        var nw = ~~(width / count);
        var nh = ~~(height / count);

        tCanvas.width = nw;
        tCanvas.height = nh;

        for (var i = 0; i < count; i++) {
            for (var j = 0; j < count; j++) {
                tctx.drawImage(img, i * nw * ratio, j * nh * ratio, nw * ratio, nh * ratio, 0, 0, nw, nh);

                ctx.drawImage(tCanvas, i * nw, j * nh, nw, nh);
            }
        }
    } else {
        ctx.drawImage(img, 0, 0, width, height);
    }

    //进行最小压缩
    var ndata = canvas.toDataURL("image/jpeg", 0.1);

    console.log("压缩前：" + initSize);
    console.log("压缩后：" + ndata.length);
    console.log("压缩率：" + ~~(100 * (initSize - ndata.length) / initSize) + "%");

    tCanvas.width = tCanvas.height = canvas.width = canvas.height = 0;

    return ndata;
}