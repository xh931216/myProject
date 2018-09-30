
$.ajaxSetup({
            complete : function(xhr, status) {
                //拦截器实现超时跳转到登录页面
                // 通过xhr取得响应头
                var REDIRECT = xhr.getResponseHeader("REDIRECT");
                //如果响应头中包含 REDIRECT 则说明是拦截器返回的
                if (REDIRECT == "REDIRECT")
                {
                    var win = window;
                    while (win != win.top)
                    {
                        win = win.top;
                    }
                    //重新跳转到 login.html 
                    top.location.href = xhr.getResponseHeader("CONTENTPATH");
                    return;
                }
            }
        });
