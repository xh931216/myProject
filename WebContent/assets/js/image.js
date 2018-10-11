//处理url
function getFilePath(input){
	if(input){//input是<input type="file">Dom对象
		if(window.navigator.userAgent.indexOf("MSIE")>=1){  //如果是IE  
	        input.select();    
	      return document.selection.createRange().text;    
	    }    
	    else if(window.navigator.userAgent.indexOf("Firefox")>=1){  //如果是火狐  {    
	        if(input.files){    
	        	return input.files.item(0).getAsDataURL();    
	        }    
	      	return input.value;    
	    }    
	    return input.value; 
	}
}

/*缩放图片*/
function DrawImage(ImgD) {
        //缩放成照片宽800.高400
        var nWidth = ImgD.width;
        var nHeight=ImgD.height;
        var image = new Image();
        image.src = ImgD.src;
        image.width = ImgD.width;
        image.height = ImgD.height;
        if (image.width > 0 && image.height > 0) {
            //宽度与高度的比例大于或等于要求显示的比例（说明比较宽）
            if (image.width / image.height >= nWidth / nHeight) {
            //如果宽度大于要求显示的宽度
                if (image.width > nWidth) {
                    ImgD.width = nWidth; //那么图片就显示要显示的宽度
                    ImgD.height = (image.height * nWidth) / image.width; 
                } else {
                    ImgD.width = image.width;
                    ImgD.height = image.height;
                }
            }
            else {
                //说明比较高
                if (image.height > nHeight) {
                    ImgD.height = nHeight;
                    ImgD.width = (image.width * nHeight) / image.height;
                } else {
                    ImgD.width = image.width;
                    ImgD.height = image.height;
                }
            }
        }
    }
