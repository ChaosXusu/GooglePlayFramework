package activity.example.chaosxu.googleplayframework.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activity.example.chaosxu.googleplayframework.ui.widget.LoadingPage;
import butterknife.ButterKnife;

/**
 * Created by lxj on 2016/5/20.
 */
public abstract class BaseFragment extends Fragment {
        private static final String TAG = "BaseFragment";
        protected LoadingPage loadingPage;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                if (loadingPage == null) {
                        loadingPage = new LoadingPage(getActivity()) {
                                @Override
                                public View createSuccessView() {
                                        View successView = getSuccessView();
                                        return successView;
                                }

                                @Override
                                public Object onLoad() {
                                        return BaseFragment.this.onLoad();
                                }
                        };
                }
                //1.初始化View,使用ButterKnife搞定
                ButterKnife.bind(this, loadingPage);
                return loadingPage;
        }

        protected abstract View getSuccessView();

        protected abstract Object onLoad();

        @Override
        public void onDestroy() {
                super.onDestroy();
                ButterKnife.unbind(this);
        }
}
