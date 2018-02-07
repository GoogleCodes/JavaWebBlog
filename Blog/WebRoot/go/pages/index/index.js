//index.js

import { Main } from '../../utils/util.js'
let urls = require('../../utils/root.js');
let $ = new Main();

//获取应用实例
var app = getApp()
Page({
  data: {
    list: [],
    videoLayers: true,
    src: ['https://getcodeing.com/static/images/abc.jpg'],
    arr: [],
    videoList: [
      {
        id: 1,
        poster: 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3709283858,1399079009&fm=27&gp=0.jpg',
        src: 'https://images.apple.com/media/cn/chinese-new-year/three-minutes/2018/f14ed516_730e_499a_8374_afd743848de6/films/three-minutes/iphone-three-minutes-tpl-cn-20180201_1280x720h.mp4'
      },
      {
        id: 2,
        poster: 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3709283858,1399079009&fm=27&gp=0.jpg',
        src: 'https://images.apple.com/media/cn/chinese-new-year/three-minutes/2018/f14ed516_730e_499a_8374_afd743848de6/films/three-minutes/iphone-three-minutes-tpl-cn-20180201_1280x720h.mp4'
      }
    ]
  },
  onLoad() {
    let that = this;
    that.getMessage();
  },

  statusPlay(e) {
    let that = this;
    let index = e.currentTarget.dataset.index;
    let id = e.currentTarget.dataset.id;
    let list = that.data.videoList;
    for (let i in list) {
      if (id !== list[i].id) {
        let videoContext = wx.createVideoContext(list[i].id.toString());
        videoContext.pause();
        that.setData({
          videoLayers: false,
        })
      }
    }
  },

  onShareAppMessage() {
    return {
      title: 'Go',
      desc: '字母表!',
      path: '/pages/index/index'
    }
  },

  getMessage() {
    let that = this;
    wx.showLoading({
      title: '加载中。。。',
    })
    $.ajax({
      url: 'ImagesServlet',
      method: "POST",
      data: {},
    }).then((res) => {
      wx.hideLoading();
      let json = {}, arr = [];
      let pathArrays = '';
      if (res.items.length == 0) {
        wx.showToast({
          title: '暂时没有内容!',
          duration: 2000,
        })
        wx.clearStorageSync('wximage');
        return false;
      }
      for (let i in res.items) {
        pathArrays = res.items;
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
        that.setData({
          list: arr,
        });
        wx.setStorageSync("wximage", arr);
      }
    });
  },

  goPage(e) {
    wx.navigateTo({
      url: '../search/search?id' + 1,
    })
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
   * 监听页面滚动
   */
  onPageScroll(e) {
    
  }

})
