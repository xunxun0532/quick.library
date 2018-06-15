package com.example.chriszou.quicksample.ui.main.index

import android.content.Intent
import android.net.Uri
import com.example.chriszou.quicksample.R
import com.example.chriszou.quicksample.ui.cuttoanim.CutToAnimActivity
import com.example.chriszou.quicksample.ui.material.CommodityDetailActivity
import kotlinx.android.synthetic.main.fragment_index.*
import kotlinx.android.synthetic.main.include_btn_index.*
import org.chris.quick.b.BaseFragment
import org.chris.quick.b.activities.WebActivity

class IndexFragment : BaseFragment() {

    override fun onResultLayoutResId(): Int = R.layout.fragment_index
    override val isShowTitle: Boolean get() = true
    //    override fun onResultToolbar(): Toolbar? = getView(R.id.toolbar)
    override fun onInit() {
        setParentMenu(R.menu.navigation, { menu ->
            when (menu?.itemId) {
                R.id.navigation0 -> showToast("首页")
                R.id.navigation1 -> showToast("发现")
                R.id.navigation3 -> showToast("我的")
            }
            true
        })
    }

    override fun onInitLayout() {
        setTitle("Index")
        customCompatSwipeRefreshLayout.isEnabled = false
    }

    override fun onBindListener() {
        tabTv1.setOnClickListener {
            val url = "tbopen://m.taobao.com/tbopen/index.html?action=ali.open.nav&module=h5&bootImage=0&source=sb&appkey=24585258&smbSid=GCyeE6miHAMCAbdDM1VnK9iW_1528249881152&rbbt=bc.mainIndex.6.0.0&params=%7B%22mtopCostTime%22%3A%22319%22%2C%22_t%22%3A%221528249881627%22%7D&h5Url=https%3A%2F%2Fm.taobao.com%2Findex.htm%3Fpoint%3D%25257B%252522from%252522%25253A%252522h5%252522%25252C%252522h5_uid%252522%25253A%252522GCyeE6miHAMCAbdDM1VnK9iW%252522%25252C%252522ap_uri%252522%25253A%252522sb_redirect_auto%252522%25252C%252522page%252522%25253A%252522mainIndex%252522%25252C%252522callType%252522%25253A%252522portListen%252522%25257D"
//            ProgressWebView.supportIntentAndScheme(activity!!,"tbopen://m.taobao.com/tbopen/index.html?action=ali.open.nav&module=h5&bootImage=0&source=sb&appkey=24585258&smbSid=GCyeE6miHAMCAbdDM1VnK9iW_1528249881152&rbbt=bc.mainIndex.6.0.0&params=%7B%22mtopCostTime%22%3A%22319%22%2C%22_t%22%3A%221528249881627%22%7D&h5Url=https%3A%2F%2Fm.taobao.com%2Findex.htm%3Fpoint%3D%25257B%252522from%252522%25253A%252522h5%252522%25252C%252522h5_uid%252522%25253A%252522GCyeE6miHAMCAbdDM1VnK9iW%252522%25252C%252522ap_uri%252522%25253A%252522sb_redirect_auto%252522%25252C%252522page%252522%25253A%252522mainIndex%252522%25252C%252522callType%252522%25253A%252522portListen%252522%25257D")
            WebActivity.startAction(activity, "自定义scheme", "http://dfdfdfdfd")
//            val uri = Uri.parse(url)
//            if (uri.pathSegments != null && uri.pathSegments.size > 0) {
//                showToast("scheme")
//            } else showToast("正常链接")
        }
        tabTv2.setOnClickListener {
            val url = "http://www.baidu.com"
//            ProgressWebView.supportIntentAndScheme(activity!!,"tbopen://m.taobao.com/tbopen/index.html?action=ali.open.nav&module=h5&bootImage=0&source=sb&appkey=24585258&smbSid=GCyeE6miHAMCAbdDM1VnK9iW_1528249881152&rbbt=bc.mainIndex.6.0.0&params=%7B%22mtopCostTime%22%3A%22319%22%2C%22_t%22%3A%221528249881627%22%7D&h5Url=https%3A%2F%2Fm.taobao.com%2Findex.htm%3Fpoint%3D%25257B%252522from%252522%25253A%252522h5%252522%25252C%252522h5_uid%252522%25253A%252522GCyeE6miHAMCAbdDM1VnK9iW%252522%25252C%252522ap_uri%252522%25253A%252522sb_redirect_auto%252522%25252C%252522page%252522%25253A%252522mainIndex%252522%25252C%252522callType%252522%25253A%252522portListen%252522%25257D")
//            WebActivity.startAction(activity, "自定义scheme", url)
            val uri = Uri.parse(url)
            if (uri.pathSegments != null && uri.pathSegments.size > 0) {
                showToast("scheme")
            } else showToast("正常链接")
        }
        tabTv3.setOnClickListener {
            startActivity(Intent(activity, CustomPullRefreshActivity::class.java))
        }
        fabContainer.setOnItemClickListener { tagView, position ->
            //            startActivity(Intent(activity, CutToAnimActivity::class.java), ActivityOptions.makeSceneTransitionAnimation(activity).toBundle())
//            CutToAnimActivity.startAction(activity!!,"转场动画",tagView)
            startActivity(Intent(activity, CommodityDetailActivity::class.java))
        }
    }

    override fun start() {

    }
}