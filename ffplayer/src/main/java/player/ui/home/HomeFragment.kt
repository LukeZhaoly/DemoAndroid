package player.ui.home

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.luke.ffplayer.R
import com.luke.ffplayer.databinding.FragmentHomeBinding
import player.hardware.OutputImageFormat
import player.hardware.VideoDecodeThread
import player.hardware.VideoToFrame
import java.util.concurrent.LinkedBlockingQueue

const val p1 = "file:///android_asset/test.mp4"
const val p2 = "${ContentResolver.SCHEME_ANDROID_RESOURCE}://com.luke.ffplayer/raw/test"
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        const val TAG = "HomeFragment"
    }

    private val videoPath by lazy {
        resources.openRawResourceFd(R.raw.test)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        binding.textHome.holder.addCallback(object : SurfaceHolder.Callback{
//            override fun surfaceCreated(holder: SurfaceHolder) {
//                var video : VideoDecodeThread
//                val init = VideoDecodeThread().apply {
//                    video = this
//                }.init(holder.surface, videoPath)
//                if (init){
//                    video.start()
//                }
//            }
//
//            override fun surfaceChanged(
//                holder: SurfaceHolder,
//                format: Int,
//                width: Int,
//                height: Int
//            ) {
//
//            }
//
//            override fun surfaceDestroyed(holder: SurfaceHolder) {
//
//            }
//
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoToFrame = VideoToFrame()
        videoToFrame.setCallback(object : VideoToFrame.Callback{
            override fun onFinishDecode() {
                Log.d(TAG, "onFinishDecode: ")
            }

            override fun onDecodeFrame(index: Int) {
                Log.d(TAG, "onDecodeFrame: $index")
            }

            override fun onDecodeFrameTime(time: Long) {
                Log.d(TAG, "onDecodeFrameTime: $time")
            }

            override fun onFrameToJpg(time: Long) {
                Log.d(TAG, "onFrameToJpg: $time")
            }

            override fun onStartDecode(time: Long) {
                Log.d(TAG, "onStartDecode: $time")
            }
        })
        videoToFrame.setSaveFrames("${context?.cacheDir}/img",OutputImageFormat.JPEG)
        videoToFrame.setEnqueue(LinkedBlockingQueue())
        videoToFrame.decode("${context?.cacheDir}/test.mp4")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}