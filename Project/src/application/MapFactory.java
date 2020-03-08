package application;

import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;



public class MapFactory implements EntityFactory{
	
	@Spawns(value = "wall")
	public Entity newWall(SpawnData data) {
		return Entities.builder()
				.from(data)
				.bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
				.with(new PhysicsComponent())
				.build();
	}


}
