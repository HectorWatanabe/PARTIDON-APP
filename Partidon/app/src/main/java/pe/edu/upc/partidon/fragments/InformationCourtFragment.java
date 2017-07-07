package pe.edu.upc.partidon.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.BusinessesCompanyRepository;
import pe.edu.upc.partidon.datasource.CourtWallRepository;
import pe.edu.upc.partidon.models.Business;
import pe.edu.upc.partidon.models.Court;


public class InformationCourtFragment extends Fragment {
        private static final String TAG = "WallCourtFragment";
        private CourtWallRepository courtWallRepository;
        private BusinessesCompanyRepository businessesCompanyRepository;
        private TextView nameOficialCourtTextView;
        private TextView locationCourtTextView;
        private TextView phoneCourtTextView;
        private TextView descriptionCourtTextView;
        private ImageView futbolCourtImageView;
        private ImageView basketCourtImageView;
        private ImageView tennisCourtImageView;
        private String telephone;


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            courtWallRepository = new CourtWallRepository(getContext());
            businessesCompanyRepository = new BusinessesCompanyRepository(getContext());

            View view = inflater.inflate(R.layout.fragment_information_court,container,false);
            nameOficialCourtTextView = (TextView) view.findViewById(R.id.nameOficialCourtTextView);
            locationCourtTextView = (TextView) view.findViewById(R.id.locationCourtTextView);
            phoneCourtTextView = (TextView) view.findViewById(R.id.phoneCourtTextView);
            descriptionCourtTextView = (TextView) view.findViewById(R.id.descriptionCourtTextView);

            futbolCourtImageView = (ImageView) view.findViewById(R.id.futbolCourtImageView);
            basketCourtImageView = (ImageView) view.findViewById(R.id.basketCourtImageView);
            tennisCourtImageView = (ImageView) view.findViewById(R.id.tennisCourtImageView);



            loadCourtsAsync();
            loadCourtsAsync1();

            phoneCourtTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call_company(v,telephone);
                }
            });

            return view;
        }

        public void call_company(View view,String phone)
        {
            String number;
            if(phone.charAt(1)== 9) {
                number = phone;
            }else
            {
                number = "01" + phone;
            }
            Intent intent = new Intent(Intent.ACTION_CALL);

            intent.setData(Uri.parse("tel:"+number));

            if(ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {

                return;
            }

            startActivity(intent);
        }

            private void loadCourtsAsync(){
                int idCourt =getArguments().getInt("key_id");
                courtWallRepository.getCourtWall(idCourt ,new CourtWallRepository.CourtWallCallback(){
                    @Override
                    public void onComplete(Court court) {
                        nameOficialCourtTextView.setText(court.getUser().getName());
                        locationCourtTextView.setText(court.getUser().getAddress());
                        phoneCourtTextView.setText(court.getPhone());
                        telephone=court.getPhone();
                        descriptionCourtTextView.setText(court.getDescription());
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void loadCourtsAsync1(){
                int idCourt = getArguments().getInt("key_id");
                businessesCompanyRepository.getBusinessesCompany(idCourt ,new BusinessesCompanyRepository.BusinessesCompanyCallback(){
                @Override
                public void onComplete(List<Business> businesses) {


                    for (Business sport :businesses) {
                        switch (sport.getSport())
                        {

                            case 1:
                                futbolCourtImageView.setImageResource(R.drawable.soccer_icon);
                                break;
                            case 2:
                                basketCourtImageView.setImageResource(R.drawable.basketball);
                                break;
                            case 3:
                                tennisCourtImageView.setImageResource(R.drawable.tennis_ball_icon);
                                break;
                        }
                    }

                }

                @Override
                public void onError(String message) {
                    Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
                }
            });

            }



    }