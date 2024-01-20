<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 미리보기와 업로드</title>
<!-- jQuery 추가 -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

<!-- enctype은 파일 업로드에서 무조건 사용되어야한다 -->
	<form action="upload.do" method="post" enctype="multipart/form-data">
<img id="preview" alt="이미지 01" src="">
<input type="file" name="file" id="fileInput">
		<input type="submit" value="업로드"><br>
		</form>
<script>
$(document).ready(function(){
    $("#fileInput").on("change", function(){
        var fileInput = document.getElementById('fileInput');
        var preview = document.getElementById('preview');

        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                // 이미지를 미리보기로 표시
                preview.src = e.target.result;

                // 이미지 크기를 조정
                resizeImage(fileInput.files[0], 200, 300, function(resizedImage) {
                    // 조정된 이미지를 다시 미리보기로 표시
                    preview.src = resizedImage;
                });
            };

            reader.readAsDataURL(fileInput.files[0]);
        }
    });

    function resizeImage(file, maxWidth, maxHeight, callback) {
        var img = new Image();
        var reader = new FileReader();

        reader.onload = function(e) {
            img.src = e.target.result;

            img.onload = function() {
                var canvas = document.createElement('canvas');
                var ctx = canvas.getContext('2d');

                var width = img.width;
                var height = img.height;

                if (width > height) {
                    if (width > maxWidth) {
                        height *= maxWidth / width;
                        width = maxWidth;
                    }
                } else {
                    if (height > maxHeight) {
                        width *= maxHeight / height;
                        height = maxHeight;
                    }
                }

                canvas.width = width;
                canvas.height = height;

                ctx.drawImage(img, 0, 0, width, height);

                var resizedImage = canvas.toDataURL('image/jpeg');
                callback(resizedImage);
            };
        };

        reader.readAsDataURL(file);
    }
});
</script>

</body>
</html>