
import { Main } from '../../utils/util.js'
let $ = new Main();

// search.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    search: '',
    list: [],
    src: ['https://getcodeing.com/static/images/abc.jpg'],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
  
  },

  getText(e) {
    let that = this;
    this.setData({
      search: e.detail.value
    });
    if (e.detail.value == '') {
      wx.showToast({
        title: '请输入内容!',
        duration: 2000,
      })
    } else {
      wx.showLoading({
        title: '获取中。。。',
      })
      $.ajax({
        url: 'SearchServlet',
        method: "POST",
        data: {
          content: that.data.search
        },
      }).then((res) => {
        if (res.items.length == 0) {
          wx.showToast({
            title: '暂时没有内容!',
          })
          wx.clearStorageSync('wxsearch');
          return false;
        }
        let json = {};
        let arr = [];
        for (let i in res.items) {
          let str = JSON.parse(res.items[i].image_path);
          let done = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\ROOT\\";
          let rep = '';
          for (let i in str) {
            rep = str[i].replace(done, "https://www.getcodeing.com/")
          }
          json = {
            image_path: rep.replace("\\", "/"),
            image_arrays: res.items[i].image_path,
            create_time: res.items[i].create_time,
            image_title: res.items[i].image_title
          };
          arr.push(json);
          wx.setStorageSync("wxsearch", arr);
          that.setData({
            list: arr
          });
          console.log(that.data.list);
        }
        wx.hideLoading();
      });
    }
  },

  previewImage(e) {
    let that = this;
    var current = e.target.dataset.src;
    let arr = [], rep = '';
    let array = JSON.parse(e.target.dataset.arrays);
    let done = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\ROOT\\";
    for (let i in array) {
      rep = array[i].replace(done, "https://www.getcodeing.com/");
      rep = rep.replace("\\", "/");
      arr.push(rep);
    }
    wx.previewImage({
      current: current,
      urls: arr,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
  
})