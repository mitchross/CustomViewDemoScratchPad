package com.example.mitchross.customviewdemo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mitchross.customviewdemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by mitchross on 11/18/14.
 */
public class CustomViewOne extends RelativeLayout
{

    protected CustomViewOneListener listener;

    @InjectView(R.id.textview_custom_view_one)
    protected TextView textViewCustomViewOne;

    @OnClick(R.id.custom_view_button)
    protected void buttonClick()
    {
        listener.onButtonClicked( "Button In Custom View One Pressed! ");
    }

    public interface CustomViewOneListener
    {
        static final CustomViewOneListener DEFAULT = new CustomViewOneListener()
        {
            @Override
            public void onButtonClicked( String message)
            {
                //no op
            }


        };

        public void onButtonClicked( String message );
    }

    public CustomViewOne( Context context )
    {
        super( context );
        init( context );
    }

    public CustomViewOne( Context context, AttributeSet attrs )
    {
        super( context, attrs );
        init( context );
    }

    public CustomViewOne( Context context, AttributeSet attrs, int defStyle )
    {
        super( context, attrs, defStyle );
        init( context );
    }

    protected void init(Context context)
    {
        inflate( context, R.layout.custom_view_one, this );
        ButterKnife.inject(this);
        listener = CustomViewOneListener.DEFAULT;

    }

    public void setListener( CustomViewOneListener listener )
    {
        if( listener != null )
        {
            this.listener = listener;
        }
    }

    public void setText( String message )
    {
        textViewCustomViewOne.setText( message );
    }
}
