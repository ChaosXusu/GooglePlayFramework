package activity.example.chaosxu.googleplayframework.ui.fragment;/**
 * Created by ChaosXu on 2016/05/30 030.
 */

import android.view.View;
import android.widget.TextView;

/**
 * Created by ChaosXu on 2016/05/30 030.
 */
public class CategoryFragment extends BaseFragment {
        @Override
        protected View getSuccessView() {
                TextView textView = new TextView(getActivity());
                textView.setText("CategoryFragment");
                return textView;
        }

        @Override
        protected Object onLoad() {
                return null;
        }
}
