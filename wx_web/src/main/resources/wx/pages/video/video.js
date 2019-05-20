//index.js
//获取应用实例
var app = getApp()
var requestUrl = "http://localhost:8888/wx/va/select.do";
var curPage = 1;
var isPullDownRefreshing = false;
Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    video :{}
  },

  lower:function(){
    console.log("reach to lower...");
    var that = this;
    this.fetchJoke();
  },
  onLoad: function () {
    console.log('onLoad')
    var that = this
    this.fetchJoke();


  },
  onPullDownRefresh:function(){
    console.log('onPullDownRefresh...');
    curPage = 1;
    isPullDownRefreshing = true;
    this.fetchJoke();
  },

  fetchJoke:function(){
    wx.showNavigationBarLoading();
    var that = this;
    wx.request({
      url: requestUrl,
      data: {
       
      },
      method: 'POST',
      success: function(res){
        // success
        console.log(res);
        console.log(res.data);
        that.setData({
          video: res.data.videos
        });
      },
      fail: function() {
        // fail
      },
      complete: function() {
        // complete
      }
    })
  }

})

