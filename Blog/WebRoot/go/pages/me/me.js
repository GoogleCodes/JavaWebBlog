// pages/me.js

import { Main } from '../../utils/util.js'
let $ = new Main();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    nickName: '',
    avatarUrl: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    let that = this;
    wx.getUserInfo({
      success(res) {
        var userInfo = res.userInfo,
          nickName = userInfo.nickName,
          avatarUrl = userInfo.avatarUrl,
          gender = userInfo.gender,
          province = userInfo.province,
          city = userInfo.city,
          country = userInfo.country;

        that.setData({
          nickName: nickName,
          avatarUrl: avatarUrl
        });
      }
    })
  },

  getImages() {
    let that = this;
    let status = '';
    wx.chooseImage({
      count: 9, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success(res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        let tempFilePaths = res.tempFilePaths;
        for (let i in tempFilePaths) {
          console.log(tempFilePaths[i]);
          wx.showLoading({
            title: '上传中...',
          })

          that.upload(tempFilePaths[i], "file");

        }
      }
    })
  },

  upload(path, name) {
    
    $.uploadAjax({
      url: 'FileUploadServlet',
      filePath: path,
      name: name,
    }).then((res) => {
      if (res.statusCode == 200) {
        wx.showToast({
          title: '上传成功！',
        })
      }
    });

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

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